module Types
  class MutationType < Types::BaseObject
    field :create_stock, mutation: Mutations::CreateStock
  end
end
