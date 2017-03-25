package com.rbc.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rbc.model.AppConfig;

public interface ConfigRepository extends CrudRepository<AppConfig, Integer> {

	AppConfig findByAppCodeAndVersion(int appCode, String version);

	@Query("select a from AppConfig a where a.appCode=:appCode order by updatedDate desc")
	Stream<AppConfig> findByAppCodeSortByDate(@Param("appCode") int appCode);

}
