package ar.edu.davinci.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import ar.edu.davinci.model.Post;
import ar.edu.davinci.model.User;

@Stateless
public class PostController {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user, String content) {
		Post post = null;
		post.setUser(user);
		post.setContent(content);
		entityManager.persist(post);
	}

	public List<Post> all() {
		CriteriaQuery<Post> cq = entityManager.getCriteriaBuilder().createQuery(Post.class);
		cq.select(cq.from(Post.class));
		return entityManager.createQuery(cq).getResultList();
	}

	public List<Post> allFromOneUser(User user) {
		String hql = "Select p from Post p where p.user > :user";

		TypedQuery<Post> q = entityManager.createQuery(hql, Post.class);

		q.setParameter("user", user);

		return q.getResultList();
	}

}
