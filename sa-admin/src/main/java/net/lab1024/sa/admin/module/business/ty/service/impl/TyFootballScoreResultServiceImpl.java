package net.lab1024.sa.admin.module.business.ty.service.impl;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyFootballScoreResult;
import net.lab1024.sa.admin.module.business.ty.domain.entity.TyIpConfig;
import net.lab1024.sa.admin.module.business.ty.domain.vo.FootballScoreResultVo;
import net.lab1024.sa.admin.module.business.ty.mapper.TyFootballScoreResultMapper;
import net.lab1024.sa.admin.module.business.ty.service.ITyFootballScoreResultService;
import net.lab1024.sa.admin.module.business.ty.service.ITyIpConfigService;
import net.lab1024.sa.common.common.domain.ResponseDTO;
import net.lab1024.sa.common.common.httpclient.HttpClientUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2023-06-06
 */
@Service
public class TyFootballScoreResultServiceImpl extends ServiceImpl<TyFootballScoreResultMapper, TyFootballScoreResult> implements ITyFootballScoreResultService {

    @Autowired
    private ITyIpConfigService tyIpConfigService;

    @Override
    public void getFootballScoreResult() {
        Date date = new Date();
        date.setTime(date.getTime() - 60*1000);
        String format = DateUtil.format(date, "yyyy-MM-ddHH:mm:ss");
        String url = "https://www.dongqiudi.com/api/data/tab/league/new/index?start="+format+"&init=1&platform=www";
        Map<String, Object> map = HttpClientUtils.doGet(url, null, null, tyIpConfigService.getIp());
        JSONObject res = JSON.parseObject(map.get("res").toString());
        JSONArray list = JSON.parseArray(res.get("list").toString());
        ballScoreResult(list);
    }

    @Override
    public void getFootballScoreImportant() {
        QueryWrapper queryWrapper1 = new QueryWrapper();
        queryWrapper1.eq("id","2");
        TyIpConfig one = tyIpConfigService.getOne(queryWrapper1);
        Map<String, Object> map = HttpClientUtils.doGet(one.getUrl(), null, null, tyIpConfigService.getIp());
        JSONObject res = JSON.parseObject(map.get("res").toString());
        JSONArray list = JSON.parseArray(res.get("list").toString());
        ballScoreResult(list);
    }

    @Override
    public void getFootballScoreIng() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("status","Playing");
        List<TyFootballScoreResult> list = this.list(queryWrapper);
        for(TyFootballScoreResult tyFootballScoreResult:list){
            Integer matchId = tyFootballScoreResult.getMatchId();
            String version = tyFootballScoreResult.getVersion();
            String url = "https://dongqiudi.com/api/data/detail/match/"+matchId+"?platform=www&version="+version+"&version="+version;
            Map<String, Object> map = HttpClientUtils.doGet(url, null, null, tyIpConfigService.getIp());
            JSONObject res = JSON.parseObject(map.get("res").toString());
            JSONObject jsonObject = JSON.parseObject(res.get("matchSample").toString());
            tyFootballScoreResult.setHomeScore(jsonObject.get("as_A").toString());
            tyFootballScoreResult.setAwayScore(jsonObject.get("as_B").toString());
            tyFootballScoreResult.setStatus(jsonObject.get("status").toString());
            tyFootballScoreResult.setMinute(jsonObject.get("minute").toString());
            this.saveOrUpdate(tyFootballScoreResult);
        }
    }




    @Override
    public ResponseDTO getFootBallList(FootballScoreResultVo footballScoreResultVo) {


        QueryWrapper queryWrapper = new QueryWrapper();
        if(StringUtils.isNotEmpty(footballScoreResultVo.getStatus())){
            queryWrapper.eq("status",footballScoreResultVo.getStatus());
        }
        if(StringUtils.isNotEmpty(footballScoreResultVo.getTime())){
            queryWrapper.eq("time",footballScoreResultVo.getTime());
        }

        if(StringUtils.isNotEmpty(footballScoreResultVo.getType())){
            queryWrapper.eq("type",footballScoreResultVo.getType());
        }
        if(StringUtils.isNotEmpty(footballScoreResultVo.getCompetitionName())){
            queryWrapper.eq("competition_name",footballScoreResultVo.getCompetitionName());
        }
        return ResponseDTO.ok(this.list(queryWrapper));
    }

    public void ballScoreResult(JSONArray list ){
        List<TyFootballScoreResult> tyFootballScoreResultList = new ArrayList();
        for (int i = 0 ; i < list.size() ; i++){
            TyFootballScoreResult tyFootballScoreResult = new TyFootballScoreResult();
            JSONObject jsonObject = JSON.parseObject(list.get(i).toString());
            int matchId = Integer.parseInt(jsonObject.get("match_id").toString());
            String status = jsonObject.get("status").toString();
            if(jsonObject.get("as_A") != null){
                tyFootballScoreResult.setHomeScore(jsonObject.get("as_A").toString());
            }else{
                tyFootballScoreResult.setHomeScore("0");
            }
            tyFootballScoreResult.setHomeId(Integer.parseInt(jsonObject.get("team_A_id").toString()));
            tyFootballScoreResult.setHomeName(jsonObject.get("team_A_name").toString());
            tyFootballScoreResult.setHomeLogo(jsonObject.get("team_A_logo").toString());
            tyFootballScoreResult.setHomeRank(jsonObject.get("rank_A").toString());

            if(jsonObject.get("as_B") != null){
                tyFootballScoreResult.setAwayScore(jsonObject.get("as_B").toString());
            }else{
                tyFootballScoreResult.setAwayScore("0");
            }
            tyFootballScoreResult.setAwayId(Integer.parseInt(jsonObject.get("team_B_id").toString()));
            tyFootballScoreResult.setAwayName(jsonObject.get("team_B_name").toString());
            tyFootballScoreResult.setAwayLogo(jsonObject.get("team_B_logo").toString());
            tyFootballScoreResult.setAwayRank(jsonObject.get("rank_B").toString());

            tyFootballScoreResult.setHalfCourt(jsonObject.get("hts_A").toString() + "-" + jsonObject.get("hts_B").toString());
            tyFootballScoreResult.setCompetitionId(Integer.parseInt(jsonObject.get("competition_id").toString()));
            tyFootballScoreResult.setCompetitionName(jsonObject.get("competition_name").toString());
            tyFootballScoreResult.setTime(jsonObject.get("date_utc").toString());
            tyFootballScoreResult.setMatchId(matchId);
            tyFootballScoreResult.setMatchTitle(jsonObject.get("match_title").toString());
            tyFootballScoreResult.setMinute(jsonObject.get("minute").toString());
            tyFootballScoreResult.setGameTime(Long.valueOf(jsonObject.get("sort_timestamp").toString()) + 28800L);
            tyFootballScoreResult.setStatus(status);
            tyFootballScoreResult.setType(jsonObject.get("cmp_type").toString());

            QueryWrapper queryWrapper = new QueryWrapper();
            queryWrapper.eq("match_id",matchId);
            TyFootballScoreResult one = this.getOne(queryWrapper);
            if(one == null){
                tyFootballScoreResultList.add(tyFootballScoreResult);
            }
//
//            if(one != null){
//                if(status.equals("Playing")){
//                    this.updateById(one);
//                }
//            }

        }
        this.saveOrUpdateBatch(tyFootballScoreResultList);
    }


}
