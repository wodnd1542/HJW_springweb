package org.HJW.article;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;

	static final Logger logger = LogManager.getLogger();

	@RequestMapping("/main")
	public String main() {
		return "main";
	}
		
	@GetMapping("/register/reference")
	public String handleStep1(@RequestParam int articleId,Model model) {
		Article reference = articleDao.getArticle(articleId);
		model.addAttribute("reference",reference);
		return "register/reference";
	}
	
	@RequestMapping("/register/write")
	public String handleStep2() {
		return "register/write";
	}
	

	@PostMapping("/register/list")
	public String handleStep3(Article article) {
		try {
			articleDao.insert(article);
			logger.debug("글 정보를 저장했습니다. {}", article);
			return "register/list";
		} catch (DuplicateKeyException e) {
			logger.debug("이미 존재하는 글입니다. email = {}", article.getTitle());
			return "register/write";
		}
	}
	
		
	@GetMapping("/articles")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

			// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
			// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articles", articleList);
		return "articles";
	}

}
