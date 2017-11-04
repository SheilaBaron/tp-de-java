/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package ar.edu.davinci.view;

import javax.inject.Inject;
import javax.inject.Named;

import ar.edu.davinci.controller.UserController;
import ar.edu.davinci.model.User;

@Named
public class CreateUserMb {

    @Inject
    private UserController userController;

    private String name;
    private String mail;
    private String password;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void  setPassword(String password) {
		this.password = password;
	}
    
    public String create(){
    	User user = new User();
    	user.setName(name);
    	user.setMail(mail);
    	user.setPassword(password);
    	userController.create(user);
    	return "Loguin.xhtml?faces-redirect=true";
    }

}
