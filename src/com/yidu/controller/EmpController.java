package com.yidu.controller;


import com.yidu.dao.EmpDao;
import com.yidu.entity.Emp;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * (Emp)表控制层
 *
 * @author makejava
 * @since 2020-11-19 14:05:03
 */
@Controller
public class EmpController {
@Autowired
EmpDao empDao;
@Autowired
Emp emp;
@ResponseBody
@RequestMapping("selectlimit")
public Map<String,Object> selectlimit(Integer page, Integer limit){
Map<String,Object> map=new HashMap<>();
map.put("code",0);
map.put("msg","");
map.put("count",empDao.count());
map.put("data",empDao.queryAllByLimit((page-1)*limit,limit));
return map;
}
@ResponseBody
@RequestMapping("deleteByid")
public int deleteByid(Integer empno){
    int i = empDao.deleteById(empno);
    return i;
}
    @ResponseBody
    @RequestMapping("update")
    public int update(HttpServletRequest request){
    String json = request.getParameter("json");
        JSONObject jsonObject = JSONObject.fromObject(json);
        Emp emp = (Emp) JSONObject.toBean(jsonObject, Emp.class);
        int update = empDao.update(emp);
        return update;
    }
  @ResponseBody
    @RequestMapping("inserts")
    public int inserts(HttpServletRequest request){
      String json = request.getParameter("json");
      JSONObject jsonObject = JSONObject.fromObject(json);
      Emp emp = (Emp) JSONObject.toBean(jsonObject, Emp.class);
      int insert = empDao.insert(emp);
      return insert;
    }

}