package org.HJW.article;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("articleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	
	static final String INSERT = "INSERT article(title, content, userId, name) VALUES(?, ?, ?, ?)";
	 
	static final String GET_ARTICLE = "SELECT articleId, userId, title, content, name, cdate FROM article WHERE articleId=?";

	static final String SELECT_ALL = "SELECT articleId, title, userId, name, content, cdate FROM article ORDER BY articleId desc LIMIT ?,?";
	
	static final String COUNT_ALL = "SELECT count(ArticleId) count FROM article";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);


	@Override
	public void insert(Article article) {
		jdbcTemplate.update(INSERT, article.getTitle(),	article.getContent(), "2014041028", "한재웅");
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Article> selectAll(int offset, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL, articleRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

	@Override
	public Article getArticle(int articleId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_ARTICLE,
				articleRowMapper,	articleId);
	}

}