module Resolvers
  class StockBySymbolResolver < Resolvers::Base
    type Types::StockType, null: true

    argument :symbol, String, required: true
    argument :foobar, String, required: true

    def resolve(arguments)
      Stock.find_by_symbol arguments[:symbol]
    end
  end
end
