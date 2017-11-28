package com.yonyou.microservice.gate.admin.rest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.cloud.common.beans.PageResultResponse;
import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.common.controller.BaseController;
import com.yonyou.microservice.gate.admin.biz.ElementBiz;
import com.yonyou.microservice.gate.admin.biz.UserBiz;
import com.yonyou.microservice.gate.admin.entity.Element;

import tk.mybatis.mapper.entity.Example;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-23 20:30
 */
@Controller
@RequestMapping("element")
public class ElementController extends BaseController<ElementBiz, Element> {
  @Autowired
  private UserBiz userBiz;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  @ResponseBody
  public PageResultResponse<Element> page(@RequestParam(defaultValue = "10") int limit,
      @RequestParam(defaultValue = "1") int offset,String name, @RequestParam(defaultValue = "0") int menuId) {
    Example example = new Example(Element.class);
    Example.Criteria criteria = example.createCriteria();
    criteria.andEqualTo("menuId", menuId);
    if(StringUtils.isNotBlank(name)){
      criteria.andLike("name", "%" + name + "%");
    }
    List<Element> elements = baseService.selectByExample(example);
    return new PageResultResponse<Element>(elements.size(), elements);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @ResponseBody
  public RestResultResponse<Element> getAuthorityElement(String menuId) {
    int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
    List<Element> elements = baseService.getAuthorityElementByUserId(userId + "",menuId);
    return new RestResultResponse<List<Element>>().success(true).data(elements);
  }

  @RequestMapping(value = "/user/menu", method = RequestMethod.GET)
  @ResponseBody
  public RestResultResponse<Element> getAuthorityElement() {
    int userId = userBiz.getUserByUsername(getCurrentUserName()).getId();
    List<Element> elements = baseService.getAuthorityElementByUserId(userId + "");
    return new RestResultResponse<List<Element>>().success(true).data(elements);
  }
}
