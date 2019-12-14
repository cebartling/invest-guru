module Types
  class QueryType < Types::BaseObject
    field :stock_by_symbol,
          Types::StockType,
          null: true,
          description: 'Find a stock by its symbol.',
          resolver: Resolvers::StockBySymbolResolver
  end
end
