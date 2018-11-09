package ru.academits.converter.generic;

import java.util.List;

public interface GenericConverter<S, D> {
    D convert(S source);

    List<D> convert(List<S> sourceList);
}

