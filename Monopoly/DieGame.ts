class Die {
  private faceValue: number
  public roll() {
    this.faceValue = Math.floor(Math.random() * 6) + 1
  }
  public getFaceValue() {
    return this.faceValue
  }
}

class Board {
  private squares: Square[]
  constructor(squares: Square[]) {
    this.squares = squares
  }
  public getSquare(oldLocation: Square, faceValueTotal: number) {
    let newLocationIndex =
      (this.squares.findIndex(square => square === oldLocation) +
        faceValueTotal) %
      this.squares.length
    return this.squares[newLocationIndex]
  }
  public printSquare() {
    let str = ''
    this.squares.forEach(square => {
      str += square.getName() + ' '
    })
    console.log('\n', str)
  }
}

class Square {
  private name: string
  constructor(name: string) {
    this.name = name
  }
  public getName() {
    return this.name
  }
}

class Piece {
  private location: Square
  public getLocation() {
    return this.location
  }
  constructor(location: Square) {
    this.location = location
  }
  public setLocation(newLocation: Square) {
    this.location = newLocation
  }
}

class Player {
  private name: string
  private piece: Piece
  private board: Board
  private dices: Die[]
  constructor(name: string, dices: Die[], board: Board, piece: Piece) {
    this.name = name
    this.dices = dices
    this.board = board
    this.piece = piece
  }
  public getName() {
    return this.name
  }
  public takeTurn() {
    let faceValueTotal = 0
    this.dices.map(dice => {
      dice.roll()
      faceValueTotal += dice.getFaceValue()
    })
    let oldSquare = this.piece.getLocation().getName()
    let oldLocation = this.piece.getLocation()
    let newLocation = this.board.getSquare(oldLocation, faceValueTotal)
    this.piece.setLocation(newLocation)
    console.log(
      this.name,
      `roll = (${faceValueTotal}) __ `,
      oldSquare,
      ' -> ',
      this.piece.getLocation().getName()
    )
  }
}

class MGame {
  private board: Board
  private dices: Die[]
  private players: Player[]
  private roundCount: number
  private playRound() {
    this.players.map(player => player.takeTurn())
  }
  constructor(playersName: string[]) {
    let dices = [new Die(), new Die()]
    let squares: Square[] = []
    let players: Player[] = []
    let squareNames: string[] = ['Bankok', 'Chaingmai', 'Chaingrai', 'Nan']
    this.dices = dices
    squareNames.forEach(name => {
      squares.push(new Square(name))
    })
    this.board = new Board(squares)
    playersName.forEach(name => {
      players.push(
        new Player(name, this.dices, this.board, new Piece(squares[0]))
      )
    })
    this.players = players
  }
  public playGame(N: number) {
    this.roundCount = 0
    while (this.roundCount < N) {
      this.board.printSquare()
      this.playRound()
      this.roundCount++
    }
  }
}

const game = new MGame(['Opor', 'Ford'])
game.playGame(3)
