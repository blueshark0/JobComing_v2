package com.job.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.job.bean.Job;
import com.job.bean.SearchMap;
import com.job.service.JobService;
import com.job.utils.TimeUtils;

/**
 * 主页核心控制
 * @author xufeng
 *
 */
@SessionAttributes("sessionMap")
@Controller
@RequestMapping("/")
public class JobCore {
	
	@Autowired
	private JobService jobService;
	private Integer pageSize = 10;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/jobs")
	public ModelAndView mainPage(@RequestParam(value="pageIndex",required=false)Integer pageIndex,SearchMap searchMap){
		
		ModelAndView mv = new ModelAndView();
		
		//先获取session中保存的searchkey
		@SuppressWarnings("unchecked")
		Map<String,Object>sessionMap = (Map<String, Object>) this.session.getAttribute("sessionMap");
		
		//url中传来的map
		Map<String,Object> map = searchMap.getMap();
		
		if(pageIndex!=null){
			
			map.put("pageIndex", pageIndex);
		}
		//以url中的map为优先
		if(sessionMap!=null){
			sessionMap.putAll(map);
		}else{
			sessionMap = new HashMap<String,Object>();
		}
		
		
		mv.setViewName("main");
		mv.addObject("jobs", jobService.getJobs(map));
		mv.addObject("sessionMap", sessionMap);

		return mv;
	}
	
	@RequestMapping("/ajax_searchKey")
	public @ResponseBody Map<String,Object>  getSearchMap(){
		
		@SuppressWarnings("unchecked")
		Map<String,Object> sessionMap = (Map<String, Object>) this.session.getAttribute("sessionMap");
		
		if(sessionMap!=null){
			return sessionMap;
		}
		return null;
	}
	
	@RequestMapping("ajax_todayJobs")
	public @ResponseBody List<Job>  getTodayJobs(){
		
		List<Job> list = new ArrayList<Job>();
		
		Map<String,Object> todayMap = new HashMap<String,Object>();
		todayMap.put("jobTime",TimeUtils.getTodayBeginDateTime());
		list = jobService.getJobs(todayMap);
		return list;
	}
	
	

}