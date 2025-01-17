package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final UserService userService;

    public ShoppingCartRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(shoppingCartRequestDto.getTickets());
        shoppingCart.setUser(userService.get(shoppingCartRequestDto.getUserId()));
        return shoppingCart;
    }
}
