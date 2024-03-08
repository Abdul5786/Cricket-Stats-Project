Cricket Team Stats API
This project provides a REST API for managing cricket player and match details. It allows users to perform CRUD operations on player details, as well as retrieve player information based on various criteria.

CRUD Operations
Create Player Details:

Endpoint: /api/players
Method: POST
Description: Inserts player details into the database.
Request Body: Player details including name, date of birth, and match ID.
Update Player Details:

Endpoint: /api/players/{playerId}
Method: PUT
Description: Updates existing player details.
Path Variable: Player ID to identify the player to be updated.
Request Body: Updated player details.
Delete Player Details:

Endpoint: /api/players/{playerId}
Method: DELETE
Description: Deletes player details from the database.
Path Variable: Player ID to identify the player to be deleted.
Get Operations
Get Player Details by ID:

Endpoint: /api/players/{playerId}
Method: GET
Description: Retrieves player details based on the provided player ID.
Path Variable: Player ID to identify the player to be retrieved.
Get Player List with Average Score More Than X:

Endpoint: /api/players?averageScoreMoreThan={X}
Method: GET
Description: Retrieves a list of players with an average score greater than X.
Query Parameter: X represents the minimum average score threshold.
Get Player List By Country:

Endpoint: /api/players?country={countryName}
Method: GET
Description: Retrieves a list of players belonging to a specific country.
Query Parameter: Country name to filter players by country.
Get List of Players Sorted by Average Score:

Endpoint: /api/players?averageScoreMoreThan={Y}&sortByAvgScore=true
Method: GET
Description: Retrieves a list of players with an average score greater than Y, sorted by average score. If two players have the same average score, the older player gets priority.
Query Parameter: Y represents the minimum average score threshold.
