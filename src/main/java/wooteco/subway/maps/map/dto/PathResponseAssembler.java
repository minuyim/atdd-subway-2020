package wooteco.subway.maps.map.dto;

import wooteco.subway.maps.line.domain.Line;
import wooteco.subway.maps.map.domain.SubwayPath;
import wooteco.subway.maps.station.domain.Station;
import wooteco.subway.maps.station.dto.StationResponse;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PathResponseAssembler {
    public static PathResponse assemble(SubwayPath subwayPath, Map<Long, Station> stations) {
        List<StationResponse> stationResponses = subwayPath.extractStationId().stream()
                .map(it -> StationResponse.of(stations.get(it)))
                .collect(Collectors.toList());

        int distance = subwayPath.calculateDistance();

        return new PathResponse(stationResponses, subwayPath.calculateDuration(), distance);
    }

    public static PathResponse assemble(SubwayPath subwayPath, Map<Long, Station> stations, List<Line> pathLines) {
        List<StationResponse> stationResponses = subwayPath.extractStationId().stream()
                .map(it -> StationResponse.of(stations.get(it)))
                .collect(Collectors.toList());

        int distance = subwayPath.calculateDistance();

        int extraFare = pathLines.stream()
                .mapToInt(Line::getExtraFare)
                .max()
                .orElse(0);
        int fare = subwayPath.calculateDistanceFare() + extraFare;

        return new PathResponse(stationResponses, subwayPath.calculateDuration(), distance, extraFare + fare);
    }
}
