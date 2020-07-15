package top.trial.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import top.trial.spring.dao.AnnotationDao;
import top.trial.spring.service.AnnotationService;

import javax.annotation.Resource;

/**
 * spring注解演示service层实现类
 *
 * @author Gaoyx
 */
@Component(value = "annotationService")
public class AnnotationServiceImpl implements AnnotationService {

    //@Autowired
    //@Qualifier("annotationDao")
    @Resource(name = "annotationDao")
    private AnnotationDao annotationDao;

    @Override
    public void execute() {
        annotationDao.accountCRUD();
    }

    public void setAnnotationDao(AnnotationDao annotationDao) {
        this.annotationDao = annotationDao;
    }
}
