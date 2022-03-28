export class User {
// classes enforce behavior around how an object can be initalized
  id :number;
  firstName: string;
  lastName: string;
  username: string;
  password: string;
  email: string;
  addresses: Address[]; // array of Address objects;

  // google Auto Constructor Generator (it's a VScode extension)
  constructor(
    id: number,
    firstName: string,
    lastName: string,
    username: string,
    password: string,
    email: string,
    addresses: Address[]
) {
    this.id = id
    this.firstName = firstName
    this.lastName = lastName
    this.username = username
    this.password = password
    this.email = email
    this.addresses = addresses
  }

}

export class Address {

  street: string;
  secondary: string;
  state: string;
  city: string;
  zip: string;

  constructor(
    street: string,
    secondary: string,
    state: string,
    city: string,
    zip: string
) {
    this.street = street
    this.secondary = secondary
    this.state = state
    this.city = city
    this.zip = zip
  }
}
