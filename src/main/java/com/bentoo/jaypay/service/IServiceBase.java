package com.bentoo.jaypay.service;

public interface IServiceBase<T,K> {
    T convertToEntity(K dto);
    K convertToDTO(T entity);
}
