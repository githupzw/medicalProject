package com.zwsyd.medical.system.datacode.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.util.IdGenerator;
import com.zwsyd.medical.system.datacode.dao.DataCodeCategoryDao;
import com.zwsyd.medical.system.datacode.pojo.entity.DataCodeCategory;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeCategoryVO;
import com.zwsyd.medical.system.datacode.service.DataCodeCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码类别信息业务层接口实现类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Service("dataCodeCategoryService")
@Transactional
public class DataCodeCategoryServiceImpl implements DataCodeCategoryService {
	@Autowired
	private DataCodeCategoryDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询对象分页查询</b>
	 * @param queryVO
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DataCodeCategoryVO> getByPage(DataCodeCategoryVO queryVO, PageVO<DataCodeCategoryVO> pageVO) throws Exception {
		//将查询视图对象切换成查询实体对象
		DataCodeCategory query = DataCodeCategory.getEntityFromVO(queryVO);
		//开启 PageHelper 分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		//进行列表查询
		List<DataCodeCategory> list = dao.findListByQuery(query);
		//根据列表创建 PageInfo 对象
		PageInfo<DataCodeCategory> pageInfo = new PageInfo<DataCodeCategory>(list);
		//提取数据
		List<DataCodeCategory> entityList = pageInfo.getList();
		//将实体列表切换成视图列表
		List<DataCodeCategoryVO> voList = new ArrayList<DataCodeCategoryVO>();
		if(entityList != null && !entityList.isEmpty()){
			for (DataCodeCategory entity : entityList) {
				//切换数据
				DataCodeCategoryVO vo = DataCodeCategoryVO.getVOFromEntity(entity);
				voList.add(vo);
			}
		}
		pageVO.setList(voList);
		pageVO.setTotalSize(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>根据编码查询对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public DataCodeCategoryVO getByCode(String code) throws Exception {
		//创建查询对象
		DataCodeCategory query = new DataCodeCategory();
		query.setCode(code);
		//进行列表查询
		List<DataCodeCategory> list = dao.findListByQuery(query);
		if(list != null && !list.isEmpty()){
			return DataCodeCategoryVO.getVOFromEntity(list.get(0));
		}

		return null;
	}

	/**
	 * <b>保存对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(DataCodeCategoryVO vo) throws Exception {
		//将视图对象切换成实体对象
		DataCodeCategory entity = DataCodeCategory.getEntityFromVO(vo);
		//设定主键
		entity.setId(idGenerator.createId());
		//进行保存
		if(dao.save(entity) >0){
			return true;
		}
		return false;
	}

	/**
	 * <b>根据主键获得视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public DataCodeCategoryVO getById(String id) throws Exception {
		//创建查询对象
		DataCodeCategory query = new DataCodeCategory();
		query.setId(id);
		//进行列表查询
		List<DataCodeCategory> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()){
			return DataCodeCategoryVO.getVOFromEntity(list.get(0));
		}
		return null;
	}


}
