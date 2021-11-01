package com.zwsyd.medical.system.datacode.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zwsyd.medical.base.pojo.vo.PageVO;
import com.zwsyd.medical.base.util.IdGenerator;
import com.zwsyd.medical.system.datacode.dao.DataCodeDao;
import com.zwsyd.medical.system.datacode.pojo.entity.DataCode;
import com.zwsyd.medical.system.datacode.pojo.vo.DataCodeVO;
import com.zwsyd.medical.system.datacode.service.DataCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>智慧医疗信息平台 - 系统功能 - 数据编码功能 - 数据代码信息业务层接口实现类</b>
 * @author ZhangWei
 * @version 1.0.0
 */
@Service("dataCodeService")
@Transactional
public class DataCodeServiceImpl implements DataCodeService {
	@Autowired
	private DataCodeDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据查询分页视图，查询分页信息</b>
	 * @param queryVO
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PageVO<DataCodeVO> getPage(DataCodeVO queryVO, PageVO<DataCodeVO> pageVO) throws Exception {
		//将查询视图切换为查询实体
		DataCode query = DataCode.getEntityFromVO(queryVO);
		//开启 PageHelper 分页查询过滤器
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		//进行列表查询
		List<DataCode> list = dao.findListByQuery(query);
		//创建 PageInfo 对象
		PageInfo<DataCode> pageInfo = new PageInfo<DataCode>(list);
		//获得分页查询的列表
		List<DataCode> entityList = pageInfo.getList();
		//创建视图列表，并且进行数据切换
		List<DataCodeVO> voList = new ArrayList<DataCodeVO>();
		if (list != null && !list.isEmpty()){
			for (DataCode entity: list) {
				DataCodeVO vo = DataCodeVO.getVOFromEntity(entity);
				voList.add(vo);
			}
		}
		pageVO.setList(voList);
		pageVO.setTotalSize(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DataCodeVO> getList(DataCodeVO queryVO) throws Exception {
		//将查询视图切换成查询实体
		DataCode query = DataCode.getEntityFromVO(queryVO);
		//进行列表查询
		List<DataCode> entityList = dao.findListByQuery(query);
		//创建视图列表
		List<DataCodeVO> voList = new ArrayList<DataCodeVO>();
		//将实体列表切换成视图列表
		if(entityList != null && !entityList.isEmpty()){
			for (DataCode entity: entityList) {
				DataCodeVO vo = DataCodeVO.getVOFromEntity(entity);
				voList.add(vo);
			}
		}
		return voList;
	}

	/**
	 * <b>根据编码查询视图对象</b>
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public DataCodeVO getByCode(String code) throws Exception {
		//创建查询对象
		DataCode query = new DataCode();
		//设定对应的查询数据
		query.setCode(code);
		//进行列表查询
		List<DataCode> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()){
			return DataCodeVO.getVOFromEntity(list.get(0));
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
	public boolean save(DataCodeVO vo) throws Exception {
		//将视图对象切换为实体对象
		DataCode entity = DataCode.getEntityFromVO(vo);
		//设定主键
		entity.setId(idGenerator.createId());
		if (dao.save(entity) > 0){
			return true;
		}
		return false;
	}

	/**
	 * <b>修改对象</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(DataCodeVO vo) throws Exception {
		//将视图对象切换为实体对象
		DataCode entity = DataCode.getEntityFromVO(vo);
		if (dao.update(entity) > 0){
			return true;
		}
		return false;
	}
	/**
	 * <b>根据主键查询视图对象</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public DataCodeVO getById(String id) throws Exception {
		//创建查询对象
		DataCode query = new DataCode();
		//设定对应的查询数据
		query.setId(id);
		//进行列表查询
		List<DataCode> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()){
			return DataCodeVO.getVOFromEntity(list.get(0));
		}
		return null;
	}

}
