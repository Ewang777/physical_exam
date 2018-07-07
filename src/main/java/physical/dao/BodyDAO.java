package physical.dao;

import physical.model.all.BodyLevel;

import java.util.List;

/**
 * created by ewang on 2018/7/6.
 */
public interface BodyDAO {
    List<BodyLevel> findAllBodyA();

    List<BodyLevel> findAllBodyB();

    List<BodyLevel> findAllBodyC();

    List<BodyLevel> findAllBodyD();
}
