//package com.yonyou.microservice.gate.common.rest;
//
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.Base64Utils;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.yonyou.cloud.common.beans.RestResultResponse;
//import com.yonyou.cloud.common.service.BaseService;
//import com.yonyou.microservice.gate.common.msg.ObjectRestResponse;
//import com.yonyou.microservice.gate.common.util.Query;
//
///**
// * ${DESCRIPTION}
// *
// * @author joy
// * @create 2017-06-15 8:48
// */
//public class BaseController<Biz extends BaseService,Entity> {
//    @Autowired
//    protected HttpServletRequest request;
//    @Autowired
//    protected Biz baseBiz;
//
//    @RequestMapping(value = "",method = RequestMethod.POST)
//    @ResponseBody
//    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
//        baseBiz.insertSelective(entity);
//        return new ObjectRestResponse<Entity>().rel(true);
//    }
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    @ResponseBody
//    public ObjectRestResponse<Entity> get(@PathVariable int id){
//        return new ObjectRestResponse<Entity>().rel(true).data(baseBiz.selectById(id));
//    }
//
//    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
//    @ResponseBody
//    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
//        baseBiz.updateSelectiveById(entity);
//        return new ObjectRestResponse<Entity>().rel(true);
//    }
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    @ResponseBody
//    public ObjectRestResponse<Entity> remove(@PathVariable int id){
//        baseBiz.deleteById(id);
//        return new ObjectRestResponse<Entity>().rel(true);
//    }
//
//    @RequestMapping(value = "/all",method = RequestMethod.GET)
//    @ResponseBody
//    public List<Entity> all(){
//        return baseBiz.selectListAll();
//    }
//    @RequestMapping(value = "/page",method = RequestMethod.GET)
//    @ResponseBody
//    public RestResultResponse<Entity> list(@RequestParam Map<String, Object> params){
//        //查询列表数据
//        Query query = new Query(params);
//        return baseBiz.selectByQuery(query);
//    }
//    public String getCurrentUserName(){
//        String authorization = request.getHeader("Authorization");
//        return new String(Base64Utils.decodeFromString(authorization));
//    }
//}
