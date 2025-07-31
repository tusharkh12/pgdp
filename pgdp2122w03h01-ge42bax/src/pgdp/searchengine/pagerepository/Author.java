package pgdp.searchengine.pagerepository;

import pgdp.searchengine.util.Date;

public class Author {
    private String firstName;
    private String lastName;
    private String address;
    private Date birthday;
    private String email;

    public Author(String firstName, String lastName, String address, String email, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean equals(Author author) {
        if ( this.birthday.equals(author.birthday) && this.firstName.equals(author.firstName)
                &&this.lastName.equals(author.lastName)  ) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public String toPrintText() {
        return firstName + " " + lastName + "\n" + address + "\n" + email+ "\n" + birthday.toString();
    }

}