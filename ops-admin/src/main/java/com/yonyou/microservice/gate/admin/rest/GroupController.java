package com.yonyou.microservice.gate.admin.rest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yonyou.cloud.common.beans.RestResultResponse;
import com.yonyou.cloud.common.controller.BaseController;
import com.yonyou.cloud.common.service.utils.TreeUtil;
import com.yonyou.microservice.gate.admin.biz.GroupBiz;
import com.yonyou.microservice.gate.admin.biz.ResourceAuthorityBiz;
import com.yonyou.microservice.gate.admin.constant.AdminCommonConstant;
import com.yonyou.microservice.gate.admin.entity.Group;
import com.yonyou.microservice.gate.admin.vo.AuthorityMenuTree;
import com.yonyou.microservice.gate.admin.vo.GroupTree;
import com.yonyou.microservice.gate.admin.vo.GroupUsers;

import io.swagger.annotations.Api;
import tk.mybatis.mapper.entity.Example;

/**
 * ${DESCRIPTION}
 *
 * @author joy
 * @create 2017-06-12 8:49
 */
@Controller
@RequestMapping("group")
@Api("群组模块")
public class GroupController extends BaseController<GroupBiz, Group> {
    @Autowired
    private ResourceAuthorityBiz resourceAuthorityBiz;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Group> list(String name,String groupType) {
        if(StringUtils.isBlank(name)&&StringUtils.isBlank(groupType)) {
            return new ArrayList<Group>();
        }
        Example example = new Example(Group.class);
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(groupType)) {
            example.createCriteria().andEqualTo("groupType", groupType);
        }

        return baseService.selectByExample(example);
    }



    @RequestMapping(value = "/{id}/user", method = RequestMethod.PUT)
    @ResponseBody
    public RestResultResponse modifiyUsers(@PathVariable int id,String members,String leaders){
        baseService.modifyGroupUsers(id, members, leaders);
        return new RestResultResponse().success(true);
    }

    @RequestMapping(value = "/{id}/user", method = RequestMethod.GET)
    @ResponseBody
    public RestResultResponse<GroupUsers> getUsers(@PathVariable int id){
        return new RestResultResponse<GroupUsers>().success(true).data(baseService.getGroupUsers(id));
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.POST)
    @ResponseBody
    public RestResultResponse modifyMenuAuthority(@PathVariable  int id, String menuTrees){
        String [] menus = menuTrees.split(",");
        baseService.modifyAuthorityMenu(id, menus);
        return new RestResultResponse().success(true);
    }

    @RequestMapping(value = "/{id}/authority/menu", method = RequestMethod.GET)
    @ResponseBody
    public RestResultResponse<List<AuthorityMenuTree>> getMenuAuthority(@PathVariable  int id){
        return new RestResultResponse().data(baseService.getAuthorityMenu(id)).success(true);
    }

    @RequestMapping(value = "/{id}/authority/element/add", method = RequestMethod.POST)
    @ResponseBody
    public RestResultResponse addElementAuthority(@PathVariable  int id,int menuId, int elementId){
        baseService.modifyAuthorityElement(id,menuId,elementId);
        return new RestResultResponse().success(true);
    }

    @RequestMapping(value = "/{id}/authority/element/remove", method = RequestMethod.POST)
    @ResponseBody
    public RestResultResponse removeElementAuthority(@PathVariable int id,int menuId, int elementId){
        baseService.removeAuthorityElement(id,menuId,elementId);
        return new RestResultResponse().success(true);
    }

    @RequestMapping(value = "/{id}/authority/element", method = RequestMethod.GET)
    @ResponseBody
    public RestResultResponse<List<Integer>> getElementAuthority(@PathVariable  int id){
        return new RestResultResponse().data(baseService.getAuthorityElement(id)).success(true);
    }


    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    @ResponseBody
    public List<GroupTree> tree(String name,String groupType) {
        if(StringUtils.isBlank(name)&&StringUtils.isBlank(groupType)) {
            return new ArrayList<GroupTree>();
        }
        Example example = new Example(Group.class);
        if (StringUtils.isNotBlank(name)) {
            example.createCriteria().andLike("name", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(groupType)) {
            example.createCriteria().andEqualTo("groupType", groupType);
        }
        return  getTree(baseService.selectByExample(example), AdminCommonConstant.ROOT);
    }


    private List<GroupTree> getTree(List<Group> groups,int root) {
        List<GroupTree> trees = new ArrayList<GroupTree>();
        GroupTree node = null;
        for (Group group : groups) {
            node = new GroupTree();
            node.setLabel(group.getName());
            BeanUtils.copyProperties(group, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees,root) ;
    }
}
