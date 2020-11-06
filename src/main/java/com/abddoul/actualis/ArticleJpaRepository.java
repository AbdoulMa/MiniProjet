package com.abddoul.actualis;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArticleJpaRepository extends CrudRepository<Article, Long> {
	@Query(value = " FROM  Article WHERE ( datePublication BETWEEN :beginDate AND :endDate) "
			+ "AND ( :region =\'null\' OR lower(regions) LIKE CONCAT('%',lower(:region ),'%') )"
			+ "AND ( :secteur = \'null\' OR lower(secteurs) LIKE CONCAT('%',lower(:secteur ),'%') )")
	List<Article> findArticlesByCriterions(@Param("beginDate")Date beginDate,@Param("endDate") Date endDate, @Param("region") final String region, @Param("secteur") final String secteur);
}
