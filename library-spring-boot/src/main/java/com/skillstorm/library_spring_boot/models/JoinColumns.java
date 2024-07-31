package com.skillstorm.library_spring_boot.models;

import jakarta.persistence.JoinColumn;

public @interface JoinColumns {

    JoinColumn[] value();

}
