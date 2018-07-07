package physical.dao;

import physical.model.grade13.change.BasisAboutChange;

import java.util.List;

/**
 * created by ewang on 2018/7/6.
 */
public interface BasisDAO {
    List<BasisAboutChange> findAllBasisFrom14To15();

    List<BasisAboutChange> findAllBasisFrom15To16();

    List<BasisAboutChange> findAllBasisFrom16To17();
}
