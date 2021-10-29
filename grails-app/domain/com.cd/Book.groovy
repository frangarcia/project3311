package com.cd

class Book extends ApplicationObject implements Comparable {

    String name
    String status

    @Override
    int compareTo(Object o) {
        id.compareTo(o.id)
    }

    boolean isEnabled() {
        return status == 'status.user.active'
    }

    void setEnabled(boolean value) {
        if (value) status = 'status.user.active'
        else status = 'status.user.inactive'
    }
}