package top.trial.demo.dao.impl;

import top.trial.demo.dao.JUnitTestDao;

public class JUnitTestDaoImpl implements JUnitTestDao {// TODO wait for using

	@Override
	public int sum(int a, int b) {
		return a + b;
	}

	@Override
	public int divide(int a, int b) {
		return a / b;
	}

}
