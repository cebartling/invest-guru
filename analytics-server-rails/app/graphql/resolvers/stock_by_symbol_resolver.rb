module Resolvers
  class StockBySymbolResolver < Resolvers::BaseResolver
    type Types::StockType, null: true

    argument :symbol, String, required: true

    def resolve(symbol:)
      # Rails.application.credentials.alphavantage[:api_key]
      Stock.find_by_symbol symbol
    end
  end
end
