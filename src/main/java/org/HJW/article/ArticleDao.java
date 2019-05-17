package org.HJW.article;

import java.util.List;

public interface ArticleDao {
	List<Article> selectAll(int offset, int count);
	
	int countAll();
	
	Article getArticle(int articleId);

	void insert(Article article);		
}
