package com.pasq.modules.custom.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.pasq.modules.custom.entity.UserEntity;
import com.pasq.modules.custom.service.UserService;
import com.pasq.common.utils.PageUtils;
import com.pasq.common.utils.Query;
import com.pasq.common.utils.R;


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
	public R list(@RequestParam Map<String, Object> params) {
		//查询列表数据
		Query query = new Query(params);

		List<UserEntity> userList = userService.queryList(query);
		int total = userService.queryTotal(query);

		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());

		return R.ok().put("page", pageUtil);
	}


	/**
	 * 信息
	 */
	@GetMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		UserEntity user = userService.queryObject(id);

		return R.ok().put("user", user);
	}
	/**
	 * 信息
	 */
	@GetMapping("/infoByTwo/{id}")
	public R infoByTwo(@PathVariable("id") Long id) {
		UserEntity user = userService.queryObjectByTWO(id);

		return R.ok().put("user", user);
	}
	/**
	 * 保存
	 */
	@PostMapping("/save")
	public R save(@RequestBody UserEntity user) {
		userService.save(user);

		return R.ok();
	}

	/**
	 * 编辑
	 */
	@PostMapping("/update")
	public R update(@RequestBody UserEntity user) {
		userService.update(user);

		return R.ok();
	}
	/**
	 * 删除
	 */
	@DeleteMapping("/delete/{id}")
	public R delete(@PathVariable("id") Long id) {
		userService.delete(id);

		return R.ok();
	}

	/**
	 * 批量删除
	 */
	@DeleteMapping("/deleteBatch")
	public R deleteBatch(@RequestBody Long[] ids) {
		userService.deleteBatch(ids);

		return R.ok();
	}

}
