package com.gridnine.testing.rules;

import com.gridnine.testing.entities.Flight;

public interface Rule {
    boolean isValid(Flight flight);
}
