package physical.dao;

import physical.model.all.ScoreLevel;

import java.util.List;

/**
 * created by ewang on 2018/7/6.
 */
public interface ScoreDAO {
    List<ScoreLevel> findAllScoreA();

    List<ScoreLevel> findAllScoreB();

    List<ScoreLevel> findAllScoreC();

    List<ScoreLevel> findAllScoreD();
}
