package com.demomic.gateway.impl.model;

import java.util.List;

public record User(String userName, String firstName, String lastName, List<String> roles) {

}
