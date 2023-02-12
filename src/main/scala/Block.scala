class Block(width: Int, length: Int, height: Int) {
	def getWidth: Int = {
            this.width  
	}
        def getHeight: Int = {
            this.height
        }
        def getLength: Int = {
            this.length
        }
        def getVolumn: Int = {
            (this.length * this.width * this.height )
        }
        def getSurfaceArea: Int = {
            2 * ( ( this.width * this.length) + (this.width * this.height) +
            ( this.length * this.height) )
        }
}
