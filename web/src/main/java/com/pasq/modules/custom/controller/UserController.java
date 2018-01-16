package com.pasq.modules.custom.controller;

import com.pasq.common.utils.Results;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pasq.modules.custom.entity.UserEntity;
import com.pasq.modules.custom.service.UserService;
import com.pasq.common.utils.PageUtils;
import com.pasq.common.utils.Query;


/**
 * @author 王伟鑫
 * @version 0.1v
 * @email wangweixin@pasq.com
 * @create 2018-01-02 11:08:54
 */
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	public Results list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<UserEntity> userList = userService.queryList(query);
		int total = userService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

		return Results.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	public Results info(@PathVariable("id") Long id) {
		UserEntity user = userService.queryObject(id);
		UserEntity userEntity = new UserEntity();
		return Results.ok().put("user", user);
	}
	/**
	 * 信息
	 */
	@GetMapping("/infoByTwo/{id}")
	public Results infoByTwo(@PathVariable("id") Long id) {
		UserEntity user = userService.queryObjectByTWO(id);

		return Results.ok().put("user", user);
	}
	/**
	 * 保存
	 */
	@PostMapping("/save")
	public Results save(@RequestBody UserEntity user) {
		userService.save(user);

		return Results.ok();
	}

	/**
	 * 编辑
	 */
	@PostMapping("/update")
	public Results update(@RequestBody UserEntity user) {
		userService.update(user);

		return Results.ok();
	}
	/**
	 * 删除
	 */
	@DeleteMapping("/delete/{id}")
	public Results delete(@PathVariable("id") Long id) {
		userService.delete(id);

		return Results.ok();
	}

	/**
	 * 批量删除
	 */
	@DeleteMapping("/deleteBatch")
	public Results deleteBatch(@RequestBody Long[] ids) {
		userService.deleteBatch(ids);

		return Results.ok();
	}

}
