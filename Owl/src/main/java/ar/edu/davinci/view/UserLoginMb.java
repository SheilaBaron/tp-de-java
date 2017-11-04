package ar.edu.davinci.view;

import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.model.User;

@Named
public class UserLoginMb {

	@Inject
	private UserController userController;

	private User currentUser;

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
	public boolean isLoged() {
		if (currentUser != null) {
			return true;
		}
		return false;
	}

	public String login() {
		userController.logThisUser(currentUser);
		if (isLoged()) {
			return "index.xhtml?faces-redirect=true";
		}
		return "Loguin.xhtml?faces-redirect=true";
	}
	
	

	

}
