package kr.co.useful.schedule.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import kr.co.useful.schedule.domain.PageMaker;
import kr.co.useful.schedule.domain.ScheduleVO;
import kr.co.useful.schedule.domain.SearchCriteria;
import kr.co.useful.schedule.service.ScheduleService;

@RestController
@RequestMapping("/scheduleList")
public class ScheduleListController {

    @Inject
	private ScheduleService service;
 
/*	//Ư���Խù��� ���� ��� ��� ��Ͽ�û
	@RequestMapping(value="", method=RequestMethod.GET)
	public Map<String, Object> pageMap(SearchCriteria cri){
		//@PathVariable ==> ��ûURL��ο� ���޵� �Ķ���� ������ ���
	   System.out.println("cri: "+ cri);
	   
        
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
	   Map<String,Object> map = new HashMap<>();
	   List<ScheduleVO> list=null;
	   try {
		  list = service.listSearchCriteria(cri);
		   map.put("pageMaker", pageMaker);
		   map.put("list", list);
	   
	   } catch (Exception e) {
		e.printStackTrace();
	   }
	   return map;
	}*/
	
	
	//���
		@RequestMapping(value="/all", method=RequestMethod.GET)
		public List<ScheduleVO> list(){
			//@PathVariable ==> ��ûURL��ο� ���޵� �Ķ���� ������ ���
		  
		   List<ScheduleVO> list=null;
		   try {
			  list = service.listCo();
		   } catch (Exception e) {
			e.printStackTrace();
		   }
		   return list;
		}
		
	
	
    
}
	

