Cricket Team Stats Project

The Cricket Team Stats project is a RESTful API-based application designed to manage and retrieve cricket player and match data efficiently. As a member of a cricket board's technical expertise team, the aim is to provide a robust system to handle CRUD operations for player details, perform various queries to retrieve player and match data, and ensure seamless management of cricket statistics.

Key Features:

CRUD Operations:

Create, update, and delete player details.
Insert and manage match details associated with players.
GET Operations:

Retrieve player details by player ID.
Get a list of players with an average score more than a specified threshold.
Retrieve a list of players from a specific country.
Fetch a sorted list of players based on average scores, with older players given priority in case of ties.
Player Details:

Each player entry includes unique ID, name, date of birth, country, and average score.
Player details are stored in a dedicated database table (player_details) with appropriate entity mappings.
Match Details:

Match entries contain a unique ID, score, and stadium information.
Matches are associated with players using a many-to-one relationship, allowing easy retrieval of match details for each player.
