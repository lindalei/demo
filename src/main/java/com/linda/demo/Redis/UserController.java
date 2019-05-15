//package com.linda.demo.Redis;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/user")
//@Api(tags="用户API")
//public class UserController {
//
//    @Autowired
//    IUserService userService;
//
//
//    @PostMapping("update")
//    @ApiOperation(value="用户修改")
//    //更新时 直接删除缓存 以保证下次获取时先从数据库中获取最新数据
//    @CacheEvict(value="OKONG", key="#userReq.id")
//    public Map<String,String> updateUser(@Valid @RequestBody UserReq userReq){
//
//        if(userReq.getId() == null || "".equals(userReq.getId())) {
//            throw new CommonException("0000", "更新时ID不能为空");
//        }
//        User user = new User();
//        user.setCode(userReq.getCode());
//        user.setName(userReq.getName());
//        user.setId(Long.parseLong(userReq.getId()));
//        userService.updateById(user);
//        Map<String,String> result = new HashMap<String,String>();
//        result.put("respCode", "01");
//        result.put("respMsg", "更新成功");
//        return result;
//    }
//
//    @GetMapping("/get/{id}")
//    @ApiOperation(value="用户查询(ID)")
//    @ApiImplicitParam(name="id",value="查询ID",required=true)
//    @Cacheable(value="OKONG",key="#id")
//    public Map<String,Object> getUser(@PathVariable("id") String id){
//        //查询
//        User user = userService.selectById(id);
//        if(user == null) {
//            throw new CommonException("0001", "用户ID：" + id + "，未找到");
//        }
//        UserResp resp = UserResp.builder()
//                .id(user.getId().toString())
//                .code(user.getCode())
//                .name(user.getName())
//                .status(user.getStatus())
//                .build();
//        Map<String,Object> result = new HashMap<String,Object>();
//        result.put("respCode", "01");
//        result.put("respMsg", "成功");
//        result.put("data", resp);
//        return result;
//    }
//
//
//
//}