package com.zwsyd.medical.system.info.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.system.info.dao.IdentityDao;
import com.zwsyd.medical.system.info.pojo.entity.Identity;
import com.zwsyd.medical.system.info.pojo.vo.IdentityVO;
import com.zwsyd.medical.system.info.service.IdentityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统用户身份信息业务层接口</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Service("identityService")
@Transactional
public class IdentityServiceImpl implements IdentityService {
	@Autowired
	private IdentityDao dao;
	/**
	 * <b>根据查询对象进行分页查询</b>
	 * @param pageVO
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	public PageVO<IdentityVO> getPage(PageVO<IdentityVO> pageVO, IdentityVO queryVO) throws Exception{
		//将查询的 VO 对象切换成 entity 对象
		Identity query = new Identity();
		//进行切换,提取VO对象的值，拷贝到实体的query里去
		BeanUtils.copyProperties(queryVO, query);
		//开启分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		//进行列表查询
		List<Identity> list = dao.findListByQuery(query);
		//根据所查询获得的列表创建 PageInfo 对象
		PageInfo<Identity> pageInfo = new PageInfo<Identity>(list);
		//将列表切换为视图列表
		List<IdentityVO> voList = new ArrayList<IdentityVO>();
		//获得实体列表
		List<Identity> entityList = pageInfo.getList();
		if(entityList != null && !entityList.isEmpty()){
			//进行数据切换
			for (Identity entity:entityList) {
				//创建对应的 VO 对象
				IdentityVO vo = new IdentityVO();
				BeanUtils.copyProperties(entity, vo);
				//将数据准备好的 vo 存储到列表中
				voList.add(vo);
			}
		}
		//将获得的列表设定到 PageVO 中
		pageVO.setList(voList);
		pageVO.setTotalSize(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());


		return pageVO;
	}

}
