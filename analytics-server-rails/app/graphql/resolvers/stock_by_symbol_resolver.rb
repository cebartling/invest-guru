module Resolvers
  class StockBySymbolResolver < Resolvers::BaseResolver
    type Types::StockType, null: true

    argument :symbol, String, required: true
    argument :foobar, String, required: true

    def resolve(arguments)
      # Rails.application.credentials.alphavantage[:api_key]
      Stock.find_by_symbol arguments[:symbol]
    end
  end
end
