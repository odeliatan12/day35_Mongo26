export interface Bgg{
    games: Games[]
    limit: number
    offset: number
    total: number
}

export interface Games{
    game_id: number
    name: string
}

export interface GamesDetails{
    game_id: number
    name: string
    year: number
    ranking: number
    users_rated: number
    url: string
    image: string
}