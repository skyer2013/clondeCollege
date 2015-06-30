package com.cloudunicollege.dao;

import java.io.Serializable;
import java.util.List;

/**
 * ????????
 *
 * @author www.java1234.com
 *
 */
public interface BaseDao<T> {
	T load(Class<T> c, Serializable id);
	/**
	 * ??????
	 *
	 * @param o
	 * @return
	 */
	Serializable save(T o);

	/**
	 * ??????
	 *
	 * @param o
	 */
	void delete(T o);

	/**
	 * ??????
	 *
	 * @param o
	 */
	void update(T o);

	/**
	 * ???????
	 *
	 * @param o
	 */
	void saveOrUpdate(T o);

	/**
	 * ??
	 *
	 * @param hql
	 * @return
	 */
	List<T> find(String hql);

	/**
	 * ????
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	List<T> find(String hql, Object[] param);

	/**
	 * ????
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	List<T> find(String hql, List<Object> param);

	/**
	 * ????(???)
	 *
	 * @param hql
	 * @param param
	 * @param page
	 *            ?????
	 * @param rows
	 *            ????????
	 * @return
	 */
	List<T> find(String hql, Object[] param, Integer page, Integer rows);

	/**
	 * ????(???)
	 *
	 * @param hql
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 */
	List<T> find(String hql, List<Object> param, Integer page, Integer rows);

	/**
	 * ??????
	 *
	 * @param c
	 *            ????
	 * @param id
	 * @return Object
	 */
	T get(Class<T> c, Serializable id);

	/**
	 * ??????
	 *
	 * @param hql
	 * @param param
	 * @return Object
	 */
	T get(String hql, Object[] param);

	/**
	 * ??????
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	T get(String hql, List<Object> param);

	/**
	 * select count(*) from ?
	 *
	 * @param hql
	 * @return
	 */
	Long count(String hql);

	/**
	 * select count(*) from ?
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	Long count(String hql, Object[] param);

	/**
	 * select count(*) from ?
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	Long count(String hql, List<Object> param);

	/**
	 * ??HQL??
	 *
	 * @param hql
	 * @return ????
	 */
	Integer executeHql(String hql);

	/**
	 * ??HQL??
	 *
	 * @param hql
	 * @param param
	 * @return ????
	 */
	Integer executeHql(String hql, Object[] param);

	/**
	 * ??HQL??
	 *
	 * @param hql
	 * @param param
	 * @return
	 */
	Integer executeHql(String hql, List<Object> param);

}