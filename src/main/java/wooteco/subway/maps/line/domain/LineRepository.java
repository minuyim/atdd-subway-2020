package wooteco.subway.maps.line.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineRepository extends JpaRepository<Line, Long> {
    @Override
    List<Line> findAll();

    List<Line> findDistinctByIdIn(List<Long> ids);
}
