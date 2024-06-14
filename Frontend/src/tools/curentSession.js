export const gameId = () => curentSession.getItem("gameId");
export const setGameId = (value) => curentSession.setItem("gameId", value);

export const role = () => curentSession.getItem("role");
export const setRole = (value) => curentSession.setItem("role", value);

export const playerId = () => curentSession.getItem("playerId");
export const setPlayerId = (value) => curentSession.setItem("playerId", value);