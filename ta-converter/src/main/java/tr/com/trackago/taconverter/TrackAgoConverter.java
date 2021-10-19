package tr.com.trackago.taconverter;

import java.util.List;

public interface TrackAgoConverter<E, D> {

    E dtoToEntity(D dtoObject);

    D entityToDto(E entityObject);

    List<D> map(List<E> entityObjects);

}
