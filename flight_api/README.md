# HOW TO USE

send a `GET` request to `/api/flights`, the API will send back a `JSON` array describing flights

a possible `JSON` reply can be like

```JSON
[
  {
    "aircraft": {
      "ID": 0,
      "availablePlaces": 600,
      "totalCapacity": 600
    },
    "arrivalInfo": {
      "airport": {
        "city": {
          "name": "Tanger"
        },
        "code": "TNG"
      },
      "day": "Monday",
      "time": "2021-02-19T00:00:00Z[UTC]"
    },
    "departureInfo": {
      "airport": {
        "city": {
          "name": "Tanger"
        },
        "code": "TNG"
      },
      "day": "Monday",
      "time": "2021-02-19T00:00:00Z[UTC]"
    },
    "flightNumber": 0,
    "price": 1200.0,
    "state": "NO_TRACK_INFO"
  }
]
```

to add a new flight a user can send a `POST` request to the same URI with `JSON` content

## TODO

- [ ] allow only authorized users to send POST requests, users should send a valide username and password
