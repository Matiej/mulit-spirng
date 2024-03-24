package com.emat.multispirng.controllers;

import com.emat.model.ShippingAddress;
import com.emat.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataResponse {
    private User user;
    private ShippingAddress shippingAddress;
}
